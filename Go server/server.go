package main
 
import (
    "fmt"
    "log"
    "net/http"
)
 
func main() {
    http.Handle("/", http.FileServer(http.Dir("./static")))
    http.HandleFunc("/", func(w http.ResponseWriter, r *http.Request) {
        fmt.Fprintf(w, "This is the root page")
    })
	http.HandleFunc("/home", func(w http.ResponseWriter, r *http.Request) {
        fmt.Fprintf(w, "This is the home page")
    })
    port := ":3000"
    fmt.Println("Server is running on port" + port)
    log.Fatal(http.ListenAndServe(port, nil))
}