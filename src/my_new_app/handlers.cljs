(ns my-new-app.handlers
  (:require
   [re-frame.core :as rf]
   [my-new-app.db :refer [starting-db]]))

(rf/register-handler :setup (fn [_ _] starting-db))

(rf/register-handler
  :navigate-to
  (fn [db [_ page]]
    (assoc db :active-page page)))
