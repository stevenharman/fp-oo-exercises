;; Exercise 1
(-> [1] first inc list)

;; Exercise 2
(-> [1] first inc (* 3) list)

;; Exercise 3
(-> 3 ((fn [n] (* 2 n))) inc)

;; Exercise 4
(-> (+ 1 2) (* 3) (+ 4))
