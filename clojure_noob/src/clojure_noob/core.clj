(ns clojure-noob.core
  (:gen-class))

(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (println "Hello, World!"))

(defn train
  []
  (println "Choo Choo"))
(train)

(if false
  (do (println "true boy")
      (println "yeaaaa"))
  (do (println "false boyt")
      (println "nooooooooo1")))

(when true
  (println "succces")
  (println "abraa"))

(or true false)
(or (= 1 1) (> 3 2))
(and (> 1 0) (> 5 10))

(def letters
  ["a" "b" "c"])

(get {:first-name "Charlie"
 :last-name "McFish"}
 :first-name)


{"plus" +}

{:name {:first "diego" :last "mayoral"}}


(hash-map :a 1 :b 2)

(get {:a 1 :b 2} :c "unicorns")

(get-in {:a 0 :b {:c "hoemm"}} [:b :c])

({:name "diego"} :name)

(:a {:a 2 :b 3} "Empty")

;; Default value is returned
(:d {:a 2 :b 3} "Empty")

(get [2 233 {:name "diego"}] 2)

(vector "diego" "fernandes" "mayoral")

(nth '(1 2 3) 2)

(conj [1 2 3 4] 2)

(conj '(1 2 3) 4)

; #{"a" 20 20}

(hash-set 1 2 3 3)

(set [1 23 4 4 4 2 1])
(set '(1 2 3 1 2 3))

(contains? #{1 2 3} 3)

(:a #{1 2 3 :a})

(:a #{1 2 3})

(contains? #{1 2 3} 4)

;; Function Expression
(or + -)
((or + -) 1 2 3)
((and (= 1 1) +) 1 2 3)
((first [+ 0]) 1 2 3)

(inc 1.2)
(map inc [2 4 6])

; Function Evaluation
(+ (inc 199) (/ 100 (- 7 2)))
(+ 200 (/ 100 (- 7 2))) ; evaluated "(inc 199)"
(+ 200 (/ 100 5)) ; evaluated (- 7 2)
(+ 200 20) ; evaluated (/ 100 5)
220 ; final evaluation

(defn test-text
  "Returns a welcoming text"
  [name]
  (str "Hello " name " welcome to clojure functions!"))

                                        ; Using the rest parameter
(defn text
  [name]
  (str "Hello " name))

(defn multi-texts
  [& names]
  (map text names))

                                        ; When mixing rest parameter with normal parameters, the rest param comes last
(defn rest-normal
  [name & things]
  (str "Hello " name ", here are my favorite things: "
       (clojure.string/join ", " things)))

                                        ; Destructuring
(defn my-first
  [[first-thing]]
  first-thing)


(defn chooser
  [[first-choice second-choice & unimportant-choices]]
  (println (str "Here's your first choice: " first-choice))
  (println (str "Here's your seconds choice: " second-choice))
  (println (str "Here's the rest: " (clojure.string/join ", " unimportant-choices))))

                                        ;Destructure map
(defn treasure-location
  [{lat :lat lng :lng}]
  (println (str "Treasure lag: " lat))
  (println (str "Treasure lng: " lng)))

(defn second-treasure-location
  [{:keys [lat lng]}]
  (println (str "Treasure lat: " lat))
  (println (str "Treasure lng: " lng)))

                                        ;Retain original argument using the :as keyword
(defn receive-treasure-location
  [{:keys [lat lng] :as treasure-location}]
  (println (str "Lat: " lat))
  (println (str "Lng: " lng))
  (println treasure-location))

                                        ; Clojure returns the last form evaluated.
(defn illustrative-func
  []
  (+ 1 30)
  20
  "Joee")

                                        ; Function body using if expression
(defn number-comment
  [x]
  (if (> x 6)
    "Oh my god, big numba"
    "Small numba"))

                                        ; Anonymous function

(map (fn [name] (str "Hi " name)) ["diego" "amanda" "luiz"])

((fn [x] (* x 3)) 8)


(def my-special-multiplier
  (fn [x] (* x x)))
                                        ; Anonymous functions with reader macros
(#(* % 3) 9)

(map #(str "Hi " %) ["diego" "jessica"])

(#(str %1 " and " %2) "corn" "bread")

(#(identity %&) 1 "one" :one)


                                        ; Closure
(defn inc-maker
  "Custom incrementor"
  [inc-by]
  #(+ % inc-by))

(def inc3 (inc-maker 3))

(inc3 10)














