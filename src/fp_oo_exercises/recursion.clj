;;; Exercise 1
(def factorial
  (fn [n]
    (if (or (= 0 n) (= 1 n))
      1
      (* n (factorial (- n 1))))))

(prn (factorial 0))
(prn (factorial 1))
(prn (factorial 5))


;;; Exercise 2
(def factorial-1
  (fn [n so-far]
    (if (or (= n 0)
            (= n 1))
      so-far
      (factorial-1 (dec n) (* n so-far)))))

(prn (factorial 0))
(prn (factorial 1))
(prn (factorial 5))


;;; Exercise 3
(def recursive-function
  (fn [seq so-far]
    (if (empty? seq)
      so-far
      (recursive-function (rest seq)
                          (+ (first seq) so-far)))))

(prn (recursive-function [1 2 3 4] 0))


;;; Exercise 4

(def recursive-function
  (fn [seq so-far]
    (if (empty? seq)
      so-far
      (recursive-function (rest seq)
                          (* (first seq) so-far)))))

(prn (recursive-function [1 2 3 4] 1))

(def recursive-function
  (fn [combinator seq so-far]
    (if (empty? seq)
      so-far
      (recursive-function combinator
                          (rest seq)
                          (combinator (first seq) so-far)))))

(prn (recursive-function + [1 2 3 4] 0))
(prn (recursive-function * [1 2 3 4] 1))


;;; Exercise 5
(def my-combine
  (fn [something so-far]
    (merge so-far {something (count so-far)})))
    ;(assoc so-far something 0)))

(recursive-function my-combine [:a :b :c] {})

