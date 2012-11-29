; http://rosalind.info/problems/dna/

(require 'clojure.string)

; read lines, save first line
(def dna ((clojure.string/split-lines (slurp "dna.txt")) 0))

(defn count-strand [strand dna]
  (count (filter #(= % strand) dna)))

(def counts (map #(count-strand % dna) [\A \C \G \T]))

(println (clojure.string/join " " counts))
