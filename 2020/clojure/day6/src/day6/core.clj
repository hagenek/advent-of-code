(ns day6.core
  (:require [clojure.string :as s])
  (:gen-class))

(def demo-input "abc

a
b
c

ab
ac

a
a
a
a

b")

(def real-input (slurp " ../../resources/input.txt"))

(defn remove-newlines [s] (s/replace s #"\r\n" ""))
(def sum-length  (fn [acc, coll] (+ (count coll) acc)))

(->> (s/split real-input #"\r\n\r\n")
     (map remove-newlines)
     (map set)
     (reduce sum-length 0))

