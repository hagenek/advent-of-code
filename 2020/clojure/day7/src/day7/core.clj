(ns day7.core
  (:require [clojure.java.io :as io]
            [clojure.string :as s])
  (:gen-class))

(def input (line-seq (io/reader (io/resource "input.txt"))))
(def demo-input (line-seq (io/reader (io/resource "demoinput.txt"))))

(def find-count-and-color (partial re-find #"(\d+) (\w+ \w+)"))

(let [s "vibrant plum bags contain 5 faded blue bags, 6 dotted black bags."
      #_"faded blue bags contain no other bags."
      [bag & deps] (s/split s #"\s?(contain|,)\s?")
      color (re-find #"\w+ \w+" bag)]
  (map (comp next find-count-and-color) deps)
  )

;; (["5 faded blue" "5" "faded blue"] ["6 dotted black" "6" "dotted black"])
;; (("5" "faded blue") ("6" "dotted black"))
;; 
(next [])


