(ns day5.core
  (:require [clojure.math.numeric-tower :as math]
            [clojure.string :as s]))

;; BFFFBBFRRR: row 70, column 7, seat ID 567.
;; FFFBBBFRRR: row 14, column 7, seat ID 119.
;; BBFFBBFRLL: row 102, column 4, seat ID 820.

(def test-input (s/split "BFFFBBFRRR\r\nFFFBBBFRRR\r\nBBFFBBFRLL\r\n" #"\r\n"))
(def test-string "RLR")
(def real-input (s/split (slurp " ../../resources/input.txt") #"\r\n"))

;; B 0 - 127 => 0 - 63 B => 0 - 31 F => 15 - 31 => F => 

(defn get-new-lower [range]
  (assoc range :lower (math/ceil
                       (+
                        (get range :lower)
                        (/
                         (- (get range :upper)
                            (get range :lower))
                         2)))))

;; ID forumulae: Row * 8 + Column


(defn get-new-upper [range]
  (assoc range :upper (- (get range :upper)
                         (math/ceil
                          (/ (- (get range :upper)
                                (get range :lower)) 2)))))

(defn progress-rowfind [ranged char]
  (if (= char \F)
    (let [new-range (get-new-upper ranged)]
      new-range)
    (let [new-range (get-new-lower ranged)]
      new-range)))

(defn progress-columnfind [ranged char]
  (if (= char \L)
    (let [new-range (get-new-upper ranged)]
      new-range)
    (let [new-range (get-new-lower ranged)]
      new-range)))


(defn find-row
  [seq-string]
  (let [row-seq (take 7 seq-string)]
    (loop [map-range {:lower 0 :upper 127} char row-seq]
      (if (= (first char) nil)
        (:upper map-range)
        (recur (progress-rowfind map-range (first char)) (rest char))))))

(defn find-column
  [seq-string]
  (let [row-seq (drop 7 seq-string)]
    (loop [map-range {:lower 0 :upper 7} char row-seq]
      (if (= (first char) nil)
        (:lower map-range)
        (recur (progress-columnfind map-range (first char)) (rest char))))))

(defn create-row-column-id-map [ten-char-string]
  (let [row (find-row ten-char-string) column (find-column ten-char-string)]
    {:row row
     :column column
     :id (+ (* row 8) column)}))

(def parsed-data-map (map create-row-column-id-map real-input))

(def id-map (map (fn [data-map] (:id data-map)) parsed-data-map))
(def sorted-list (sort id-map))

(defn find-missing-seat [num-seq]
  (loop [remaining-seq num-seq]
    (if (not=  (- (second remaining-seq) (first remaining-seq)) 1)
      (+ (first remaining-seq) 1)
      (recur (rest remaining-seq)))))

