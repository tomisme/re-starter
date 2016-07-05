(defproject re-starter "0.1.0-SNAPSHOT"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}

  :dependencies [[org.clojure/clojure "1.9.0-alpha8"]
                 [org.clojure/clojurescript "1.9.93"]
                 [devcards "0.2.1-7"]
                 [re-frame "0.7.0"]
                 [reagent "0.6.0-alpha"]
                 [kibu/pushy "0.3.6"]
                 [bidi "2.0.9"]]

  :plugins [[lein-figwheel "0.5.4-4"]
            [lein-cljsbuild "1.1.3"]]

  :clean-targets ^{:protect false} ["resources/public/js/compiled"
                                    "target"]

  :cljsbuild {:builds
              [{:id "cards"
                :source-paths ["src/app" "src/cards"]
                :figwheel {:devcards true}
                :compiler {:main       "cards.core"
                           :asset-path "js/compiled/devcards_out"
                           :output-to  "resources/public/js/compiled/cards.js"
                           :output-dir "resources/public/js/compiled/devcards_out"
                           :source-map-timestamp true}}
               {:id "dev"
                :source-paths ["src/app"]
                :figwheel {:on-jsload "app.core/render-app"}
                :compiler {:main       "app.core"
                           :asset-path "js/compiled/out"
                           :output-to  "resources/public/js/compiled/app.js"
                           :output-dir "resources/public/js/compiled/out"
                           :source-map-timestamp true}}
               {:id "prod"
                :source-paths ["src/app"]
                :compiler {:main       "app.core"
                           :asset-path "js/compiled/out"
                           :output-to  "resources/public/js/compiled/app.js"
                           :optimizations :advanced}}]}

  :figwheel {:css-dirs ["resources/public/css"]})
