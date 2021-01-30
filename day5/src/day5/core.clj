(ns day5.core
  (:gen-class))

;; BFFFBBFRRR: row 70, column 7, seat ID 567.
;; FFFBBBFRRR: row 14, column 7, seat ID 119.
;; BBFFBBFRLL: row 102, column 4, seat ID 820.

(def test-input "BFFFBBFRRR\r\nFFFBBBFRRR\r\nBBFFBBFRLL\r\n")
(def test-string "BBFFBBFRLL")
(def real-input slurp " ../../resources/input.txt")

(defn find-row
  [seq-string]
  (let [row-seq (take 7 seq-string)]
    row-seq))

(find-row "BFFFBBFRRR")