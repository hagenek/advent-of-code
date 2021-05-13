(ns day8.core
  (:require [clojure.java.io :as io]))

;; Finally on the plain

(def test-input "nop +0
acc +1
jmp +4
acc +3
jmp -3
acc -99
acc +1
jmp -4
acc +6")
;; => #'day8.core/test-input

(def parse-instructions (partial re-seq #"(\w{3}) ([+-]\d+)"))
;; => #'day8.core/parse-instructions

(parse-instructions test-input)

(defn parse-input
  [test-input]
  (vec (for [[_ op arg] (parse-instructions test-input)]
         [(keyword op) (read-string arg)])))

(read-string "-5")
;; => -5

(with-open)

(let [reader (io/reader (io/resource "puzzle_input_01.txt"))
      s      (doall (line-seq reader))]
  (.close reader))

(type (read-string "-5"))
;; => java.lang.Long

(parse-input test-input)
;; => [[:nop 0] [:acc 1] [:jmp 4] [:acc 3] [:jmp -3] [:acc -99] [:acc 1] [:jmp -4] [:acc 6]]

(let [program  (parse-input test-input)
      init-ctx {:pc 0 :acc 0 :seen? #{}}]
  (loop [{:keys [pc acc seen?] :as ctx} init-ctx]
    (if (seen? pc)
      acc
      (let [[op arg] (get program pc)]
        (case op
          :nop
          (recur (-> ctx
                     (update :pc inc)
                     (update :seen? conj pc)))
          :acc
          (recur (-> ctx
                     (update :acc + arg)
                     (update :pc inc)
                     (update :seen? conj pc)))
          :jmp
          (recur (-> ctx
                     (update :pc + arg)
                     (update :seen? conj pc))))))))



((conj #{} 3) 3)

;; => 3

(#{0 1} 2)
;; => nil

((conj #{} 3) 7)
;; => nil
