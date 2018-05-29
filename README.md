# XMLAnalyzer
That small app consumes the original page(xml or html) to collect all the required information about the target element
(it is attribute id="make-everything-ok-button". This id is the only exact criteria, to find the target element in the input file.)
Then the program is able to find this element in diff-case xml or HTML document that differs a bit from the original page.

to run this app:
java -jar xmlAnalyzer-1.0-jar-with-dependencies.jar <input_origin_file_path> <input_other_sample_file_path>
