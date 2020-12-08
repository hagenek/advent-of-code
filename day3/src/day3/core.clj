(ns day3.core
  (:require [clojure.string :as str]
            [clojure.java.io :as io]))

(def demo-input "..##.......
#...#...#..
.#....#..#.
..#.#...#.#
.#...##..#.
..#.##.....
.#.#.#....#
.#........#
#.##...#...
#...##....#
.#..#...#.#")

(def real-input (slurp (io/resource "input.txt")))

(defn input->map [input]
  (mapv (fn [row]
        (mapv {\# true \. false} row))
        (str/split input #"\n")))

(defn tree? [m x y]
  (let [width (count (first m))]
    (get-in m [y (mod x width )])))

(defn sled [[down-x down-y] [my-map x y trees]]
  (let [x (+ x down-x)
        y (+ y down-y)
        tree? (tree? my-map x y)]
    (cond
      (nil? tree?)
      (reduced trees)

      (true? tree?)
      [my-map x y (inc trees)]

      :else 
      [my-map x y trees])))

(defn sled-down [slope input]
  @(first
    (drop-while 
     (complement reduced?)
     (iterate (partial sled slope) [(input->map input) 0 0 0]))))

(sled-down [3 1] demo-input) 
;; => 7

(sled-down [3 1] real-input)
;; 280

(def slopes [[1 1]
             [3 1]
             [5 1]
             [7 1]
             [1 2]])

(apply * (for [s slopes]
           (sled-down s real-input)))




