import './App.css';
import React, {Component} from "react";
import {BrowserRouter as Router, Redirect, Route} from 'react-router-dom'
import Books from "./components/Books/books"
import EShopService from "./repository/eshopRepository";
import ProductAdd from "./components/Books/productAdd"
import BookEdit from "./components/Books/BookEdit";
import Header from "../src/Header/header"
import Categories from "./components/Categories/Categories"



class App extends Component {

    constructor(props) {
        super(props);
        this.state = {
            books: [],
            categories:[],
            authors:[],
            selectedBook:{}


        }
    }

    render() {
        return (
            <Router>
<Header/>
                <main>
                    <div className="container">


                        <Route path={"/books"} exact render={() =>
                            <Books books={this.state.books}
                                   onEditBook={this.getBook}
                                   onDelete={this.deleteBook} onMarkAsTaken={this.markAsTaken}/>}/>

                        <Route path={"/categories"} exact render={() =>
                            <Categories kategorii={this.state.categories}
                                    />}/>

                        <Route path={"/"} exact render={() =>
                            <Books books={this.state.books}
                                   onEditBook={this.getBook}
                                   onDelete={this.deleteBook} onMarkAsTaken={this.markAsTaken}/>}/>



                        <Route path={"/books/add"} exact render={() =>
                            <ProductAdd categories={this.state.categories}
                                        authors={this.state.authors}
                                        onAddProduct={this.addBook}/>}/>

                        <Route path={"/books/edit/:id"} exact render={()=><BookEdit categories={this.state.categories}
                        authors={this.state.authors}
                          selectedBook={this.state.selectedBook}
                         onEditBook={this.editBook}  />}/>

                    </div>
                </main>
            </Router>
        );
    }

    componentDidMount() {
        this.loadBooks();
        this.loadCategories();
        this.loadAuthors();
    }



    loadBooks = () => {
        EShopService.fetchBooks()
            .then((data) => {
                this.setState({
                    books: data.data

                })
            });
    }
    editBook = (id,name, category,author,availableCopies) => {
        console.log(id,name,category,author,availableCopies);
        EShopService.editBook(id,name, category,author,availableCopies)
            .then(() => {
                this.loadBooks();
            });
    }

    getBook = (id) => {
        EShopService.getBook(id)
            .then((data) => {
                this.setState({

                    selectedBook: data.data

                })
            });
    }

    loadCategories = () => {
        EShopService.fetchCategories()
            .then((data) => {
                this.setState({
                    categories: data.data
                })
            });
    }



    loadAuthors = () => {
        EShopService.fetchAuthors()
            .then((data) => {
                this.setState({
                    authors: data.data
                })
            });
    }


    deleteBook = (id) => {
        EShopService.deleteBook(id)
            .then(() => {
                this.loadBooks();
            });
    }
    addBook = (name, category,author,availableCopies) => {
        EShopService.addProduct(name, category,author,availableCopies)
            .then(() => {
                this.loadBooks();
            });
    }

   markAsTaken =   (id) => {
        EShopService.markAsTaken(id)
            .then(() => {

               this.loadBooks();


            });



    }



}

export default App;

