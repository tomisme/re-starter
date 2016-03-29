(ns my-new-app.handlers
  (:require
   [re-frame.core :as rf]
   [my-new-app.routes :as routes]
   [my-new-app.db :as db]))

(rf/register-handler
  :setup
  (fn [_ _]
    (do (routes/setup!)
        db/initial-db)))

(rf/register-handler
  :navigate-to
  (fn [db [_ page]]
    (assoc db :active-page page)))
