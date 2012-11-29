; http://rosalind.info/problems/revc/

(require 'clojure.string)

(def dna ((clojure.string/split-lines (slurp "revc.txt")) 0))

(defn complement-base [base]
  (cond
    (= base \T) \A
    (= base \A) \T
    (= base \C) \G
    (= base \G) \C))

(println (apply str (reverse (map complement-base dna))))
