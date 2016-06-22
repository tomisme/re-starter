(ns cards.core
  (:require-macros
   [devcards.core :refer [defcard]]))

(enable-console-print!)

(defcard hello
  {:a "ahhh"
   :b "bahhh"})
