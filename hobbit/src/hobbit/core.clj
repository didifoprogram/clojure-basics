(ns hobbit.core
  (:gen-class))

(def asym-hobbit-body-parts [{:name "head" :size 3}
                             {:name "left-eye" :size 1}
                             {:name "left-ear" :size 1}
                             {:name "mouth" :size 1}
                             {:name "nose" :size 1}
                             {:name "neck" :size 1}
                             {:name "left-shoulder" :size 3}
                             {:name "left-upper-arm" :size 3}
                             {:name "chest" :size 10}
                             {:name "back" :size 10}
                             {:name "left-forearm" :size 3}
                             {:name "abdomen" :size 6}
                             {:name "left-kidney" :size 1}
                             {:name "left-hand" :size 2}
                             {:name "left-knee" :size 2}
                             {:name "left-thigh" :size 4}
                             {:name "left-lower-leg" :size 3}
                             {:name "left-achilles" :size 1}
                             {:name "left-foot" :size 2}])
(defn matching-part
  [part]
  {:name (clojure.string/replace (:name part) #"^left-" "right-")
   :size (:size part)})



(defn symmetrize-body-parts
  "Expects a seq of maps that have :name and :size"
  [asym-body-parts]
  (loop [remaining-asym-parts asym-body-parts
         final-body-parts []]
    (if (empty? remaining-asym-parts)
      final-body-parts
      (let [[part & remaining] remaining-asym-parts]
        (recur remaining
               (into final-body-parts
                     (set [part (matching-part part)])))))))



(comment

                                        ; Let -----------------
  Let binds names to values
  (let [x 3]
    x)

  (def dalmatian-list
    ["Pongo" "Perdita" "Puppy 1" "Puppy 2"])

  (let [dalmatians (take 2 dalmatian-list)]
    dalmatians)

                                        ; Let defines a new scope
  (def x 0)
  (let [x 1] x) ; Local scope

                                        ; Reference existing bindings
  (def x 0) ; Global scope
  (let [x (inc x)] x)

                                        ; Rest parameter
  (let [[pongo & dalmatians] dalmatian-list]
    [pongo dalmatians])
  ;=> ["Pongo" ("Perdita" "Puppy 1" "Puppy 2")]

                                        ; Function into
  (into [] (set [:a :a]))
  (into [] (set ["a" "b"]))
                                        ; Loop and recur
  (loop [iteration 0]
    (println (str "Iteration " iteration))
    (if (> iteration 3)
      (println "Goodbye")
      (recur (inc iteration))))

                                        ; Same thing with normal function
  (defn recursive-printer
    ([]
     (recursive-printer 0)) ; If called with no parameter
    ([iteration]            ; If called with paramater
    (println iteration)
    (if (> iteration 3)
      (println "Goodbye!")
      (recursive-printer (inc iteration)))))
  (recursive-printer)

                                        ; Regular expressions
  (re-find #"^left-" "left-eye")
  (re-find #"^left-" "cleft-eye")
  (re-find #"left-" "cleft-eye")
  

                                        ; Reduce
  (reduce + [1 2 3])
  (reduce + 10 [1 2 3])
  
                                        ; Better implementation

  ;; Reduce (reduce f coll) (reduce f val coll)
  (defn better-symmetrize-body-parts
    "Expect a seq of maps that have a :name and :size"
    [asym-body-parts]
    (reduce (fn [final-body-parts part]
              (into final-body-parts (set [part (matching-part part)])))
            []
            asym-body-parts))

  (better-symmetrize-body-parts asym-hobbit-body-parts)

  
  )





