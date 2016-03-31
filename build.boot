(set-env!
  :source-paths #{"src"}
  :resource-paths #{"resources/public"}
  :dependencies '[[org.clojure/clojure    "1.8.0"      :scope "provided"]
                  [boot/core              "2.5.5"      :scope "test"]
                  [org.clojure/clojurescript "1.8.40" :scope "test"]
                  [adzerk/boot-cljs "1.7.228-1" :scope "test"]
                  [adzerk/boot-cljs-repl "0.3.0" :scope "test"]
                  [adzerk/boot-reload "0.4.6" :scope "test"]
                  [adzerk/boot-test "1.1.1" :scope "test"]
                  [boot-deps "0.1.6" :scope "test"]
                  [com.cemerick/piggieback "0.2.1" :scope "test"]
                  [weasel "0.7.0" :scope "test"]
                  [org.clojure/tools.nrepl "0.2.12" :scope "test"]
                  [pandeiro/boot-http "0.7.3"]
                  [devcards "0.2.1-6"]
                  [re-frame "0.7.0"]
                  [reagent "0.6.0-alpha"]
                  [kibu/pushy "0.3.6"]
                  [bidi "2.0.4"]])

(require
  '[adzerk.boot-cljs      :refer [cljs]]
  '[adzerk.boot-cljs-repl :refer [cljs-repl start-repl repl-env]]
  '[adzerk.boot-reload    :refer [reload]]
  '[adzerk.boot-test      :refer [test]]
  '[pandeiro.boot-http    :refer [serve]])

(task-options!
  cljs {:source-map true})

(deftask dev
  "Start the dev environment"
  [s speak       bool "Notify when build is done"
   p port    PORT int  "Port for web server"]
  (comp
    (serve :port port, :dir "target")
    (watch)
    (reload :on-jsload 'my-new-app.core/render-app)
    (cljs-repl)
    (cljs)
    (target :dir #{"target"})
    (if speak (boot.task.built-in/speak) identity)))

(deftask run-tests []
  (test))

(deftask autotest []
  (comp
    (watch)
    (run-tests)))
