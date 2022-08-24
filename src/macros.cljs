(ns macros)

(defmacro fx
  "Convenient wrapper arount react/useEffect"
  ([body]
   `(React/useEffect
     (fn []
       ~body
       js/undefined)
     []))
  ([body & watches]
   `(React/useEffect
     (fn []
       ~body
       js/undefined)
     [~@watches])))
