(ns app.views
  (:require
   [re-frame.core :as rf]
   [app.routes :as routes]))

(defn home-page
  []
  [:div
   [:p "This is the home page!"]
   [:p "Links:"]
   [:ul
    [:li [:a {:href (routes/url :about)} "about"]]]])

(defn about-page
  []
  [:div
   [:p "This is the about page."]
   [:p
    [:a {:href (routes/url :home)}
     "back home"]]])

(defn app
  []
  (let [page (rf/subscribe [:active-page])]
    (fn []
      [:div
       (case @page
         :home (home-page)
         :about (about-page)
         [:span "Can't find that.."])])))
