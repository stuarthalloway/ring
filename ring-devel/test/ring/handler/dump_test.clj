(ns ring.handler.dump-test
  (:use clojure.test
        ring.handler.dump)
  (:require [ring.util.test :as tu]))

(def post-req
  {:uri            "/foo/bar"
   :request-method :post
   :body           (tu/string-input-stream "post body")})

(def get-req
  {:uri            "/foo/bar"
   :request-method :get})

(deftest test-handle-dump
  (let [{:keys [status]} (handle-dump post-req)]
    (is (= 200 status)))
  (let [{:keys [status]} (handle-dump get-req)]
    (is (= 200 status))))
