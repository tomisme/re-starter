(ns my-new-app-cards.core
  (:require
   [my-new-app.views :as views]
   [devcards.core :as dc :include-macros true])
  (:require-macros
   [devcards.core :refer [defcard-doc deftest]]
   [cljs.test :refer [testing is run-tests]]))

(defn main [] (dc/start-devcard-ui!))

(defcard-doc
  "Hello"
  {:a "aa"})

(deftest sample-test
  (testing
    (is (= :a "aa"))))
