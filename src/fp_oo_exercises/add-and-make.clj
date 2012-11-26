;; Exercise 1: add with out `shift`
(def add
  (fn [this other]
    (Point
      (+ (x this) (x other))
      (+ (y this) (y other)))))

(prn (add (Point 50 50) (Point 10 -10)))
;; => {:x 60, :y 40, :__class_symbol__ Point}

;; add with `shift`
(def add
  (fn [this other]
    (shift this (x other) (y other))))

(prn (add (Point 50 50) (Point 5 -5)))
;; => {:x 55, :y 45, :__class_symbol__ Point}


;; Exercise 2: a `make` function
(def make
  (fn [class & args]
    (apply class args)))

(prn (make Triangle (make Point 1 2)
                    (make Point 1 3)
                    (make Point 3 1)))
;; => {:point1 {:x 1, :y 2, :__class_symbol__ Point}, :point2 {:x 1, :y 3, :__class_symbol__ Point}, :point3 {:x 3, :y 1, :__class_symbol__ Point}, :__class_symbol__ Triangle}


;; Exercise 3: equal-triangles?
(def equal-triangles? =)

(prn (equal-triangles? right-triangle right-triangle))
;; => true
(prn (equal-triangles? right-triangle equal-right-triangle))
;; => true
(prn (equal-triangles? right-triangle different-triangle))
;; => false


;; Exercise 4: equal-triangles? can compare more than two Triangles
(def equal-triangles? =) ;; same as above

(prn (equal-triangles? right-triangle right-triangle right-triangle))
;; => true

;; Exercise 5:
(def valid-triangle?
  (fn [& points]
    (and (= (count points) 3)
         (apply distinct? points))))

;; better:
(def valid-triangle?
  (fn [& points]
    (= (count (distinct points)) 3)))

