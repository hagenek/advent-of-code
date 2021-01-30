(ns day5.core
  (:require [clojure.math.numeric-tower :as math]))

;; BFFFBBFRRR: row 70, column 7, seat ID 567.
;; FFFBBBFRRR: row 14, column 7, seat ID 119.
;; BBFFBBFRLL: row 102, column 4, seat ID 820.

(def test-input "BFFFBBFRRR\r\nFFFBBBFRRR\r\nBBFFBBFRLL\r\n")
(def test-string "BBFFBBFRLL")
(def real-input (slurp " ../../resources/input.txt"))

(defn progress-rowfind [val char]
  (if (= char \B)
    (/ val 2)
    val))

(defn return-upper-half [num] num)
(defn return-lower-half [num] (math/floor (/ num 2)))

(defn find-row
  [seq-string]
  (let [row-seq (vec (take 7 seq-string))]
    (println row-seq)
    (reduce progress-rowfind 128 row-seq)))

