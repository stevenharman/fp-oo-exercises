;;; Exercise 1

;;; helpers
(def method-for-message
  (fn [message class]
    (message (:__instance_methods__ class))))

(def class-for-instance
  (fn [instance]
    (eval (:__class_symbol__ instance))))


(def apply-message-to
  (fn [class instance message args]
      (apply (method-for-message message class) instance args)))

;; re-define make and send-to using `apply-message-to`
(def make
  (fn [class & args]
    (let [seeded {:__class_symbol__ (:__own_symbol__ class)}]
      (apply-message-to class seeded :add-instance-values args))))

(def send-to
  (fn [instance message & args]
    (apply-message-to (class-for-instance instance) instance message args)))


;;; Exercise 2
(def Point
  {
   :__own_symbol__ 'Point
   :__instance_methods__
   {
    :add-instance-values (fn [this x y]
                           (assoc this :x x :y y))

    :class-name :__class_symbol__
    :class (fn [this] class-for-instance this)

    :shift (fn [this xinc yinc]
             (make Point
                   (+ (:x this) xinc)
                   (+ (:y this) yinc)))
    :add (fn [this other]
           (send-to this :shift (:x other)
                                (:y other)))
    }
   })

(prn (send-to (make Point 1 2) :class-name))
(prn (send-to (make Point 1 2) :class))


;;; Exercise 3
(def foo-point (make Point 1 2))

(def Point
  {
   :__own_symbol__ 'Point
   :__instance_methods__
   {
    :add-instance-values (fn [this x y]
                           (assoc this :x x :y y))

    :class-name :__class_symbol__
    :class (fn [this] class-for-instance this)

    :origin (fn [this] (make Point -0 0))
    :shift (fn [this xinc yinc]
             (make Point
                   (+ (:x this) xinc)
                   (+ (:y this) yinc)))
    :add (fn [this other]
           (send-to this :shift (:x other)
                                (:y other)))
    }
   })

(send-to foo-point :origin)
;; => {:y 0, :x 0, :__class_symbol__ Point}
;;
;; So redefining a class changes the behavior or existinging instances of the
;; class because the :__class_symbol__ is just a symbol, and is `eval`ed lazily.


;;; Exercise 4

(def apply-message-to
  (fn [class instance message args]
    (let [method-or-accessor (or (method-for-message message class) message)]
      (apply method-or-accessor instance args))))

