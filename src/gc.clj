; http://rosalind.info/problems/gc/

(use 'clojure.java.io)
(require 'clojure.string)


; compute GC-content for a given strand
(defn GC-content [strand]
  (float (/ (+ (count (filter #(= \C %) strand))
               (count (filter #(= \G %) strand)))
            (count strand))))

; helper func for max-entry comparison
(defn get-val [entry]
  (if (nil? (get entry 1))
    0
    (get entry 1)))

; max function for reduce
(defn max-entry [entry1 entry2]
  (if (> (get-val entry1) (get-val entry2))
    entry1
    entry2))

(def strands (atom {}))
(def curr_strand (atom ""))

; read strands from file
(with-open [rdr (reader "gc.txt")]
  (doseq [line (line-seq rdr)]
    (let [f_char (get line 0)]
      (if (= f_char \>)
        (do
          (reset! curr_strand (subs line 1))
          (swap! strands assoc @curr_strand ""))
        (let [old_val (get @strands @curr_strand)]
          (swap! strands assoc @curr_strand (str old_val line)))))))

; save map like {strand-id gc-content}
(def GC-contents (into {} (map #(vector (% 0) (GC-content (% 1))) @strands)))

; find strand-id with highest gc-content
(def highest (reduce max-entry {"garbage" 0} GC-contents))

(println (highest 0))
(println (str (* 100 (highest 1)) "%"))
