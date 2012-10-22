(ns projecteuler.core
	(:gen-class))

(defmacro my-eval [s] `~(read-string s))

(defn foo []
  (println "Hello, World!"))

(defn p1 [max]
	(reduce +
	(filter
		(fn [x] (or (= 0 (mod x 5)) (= 0 (mod x 3))))
		(range 1 max))))

(defn p2 [max]
	; sum of the
	(reduce +
	; even-valued
		(filter even? 
			; fibonacci numbers whose values are less than max
			((fn fib [a b]
				(lazy-seq
					(cons a (if (> (+ a b) max)
						[b]
						(fib b (+ a b))))
				))
			1 2))))

(defn -main [& args]
	(println "Welcome to my Project Euler examples. Args were: " args)
	(my-eval "(p1 `1000)")
	(my-eval "(p2 `4000000)"))