(require 'clojure.string)

(def dna ((clojure.string/split-lines (slurp "rna.txt")) 0))

(println (clojure.string/replace dna \T \U))
