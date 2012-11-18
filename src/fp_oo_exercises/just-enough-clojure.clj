;; Exercise 1
(def second (fn [list] (first (rest list))))

;; Exercise 2
(def third (fn [list] (nth list 2)))

(def third-2 (fn [list] (second (rest list))))

;; Exercise 3
(def add-squares
  (fn [& args]
    (apply + (map
               (fn [n] (* n n))
               args))))

;; Exercise 4
(def factorial
  (fn [n]
    (apply * (range 1 (inc n)))))

;; Exercise 5
;; Lots of playing around in repl...

;; Exercise 6
(def prefix-of?
  (fn [candidate sequence]
    (= (take (count candidate) sequence)
       candidate)))

;; Exercise 7
(def tails
  (fn [seq]
    (map drop
         (range 0 (inc (count seq)))
         (repeat (inc (count seq)) seq))))

;; Exercise 8
(def puzzle
  (fn [list] (list list)))

;; user => (puzzle '(1 2 3))
;; ClassCastException clojure.lang.PersistentList cannot be cast to clojure.lang.IFn  user/puzzle (NO_SOURCE_FILE:1))
;;
;; When the argument is substituted into the expanded function we get
;; ((1 2 3) (1 2 3))
;;
;; And the error is complaining about the first list NOT being something that
;; could be evaluted to a function, as is expected.

