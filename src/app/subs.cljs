(ns app.subs
  (:require
   [re-frame.core :as rf])
  (:require-macros
   [reagent.ratom :refer [reaction]]))

(rf/register-sub
  :active-page
  (fn [db _]
    (reaction (:active-page @db))))
