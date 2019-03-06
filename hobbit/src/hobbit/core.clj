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
  

  
  )





