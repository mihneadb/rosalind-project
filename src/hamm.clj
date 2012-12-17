; http://rosalind.info/problems/hamm/

(require 'clojure.string)

; read lines, save first line
(def strands (clojure.string/split-lines (slurp "hamm.txt")))
(def dna1 (strands 0))
(def dna2 (strands 1))

(println (count (filter true? (map (partial reduce not=) (map vector dna1 dna2)))))
