import axios from '../custom-axios/axios';

const EShopService = {
    fetchBooks: () => {
        return axios.get("/books");
    },
    deleteBook: (id) => {
        return axios.delete(`/books/delete/${id}`);
    },
    fetchCategories: () => {
        return axios.get("/categories");
    },
    fetchAuthors: () => {
        return axios.get("/authors");
    },

    addProduct: (name, category,author,availableCopies) => {
        console.log(availableCopies + " s")
        return axios.post("/books/add", {
            "name" : name,
            "category" : category,
            "author" : author,
            "availableCopies" : availableCopies

        })
    },
    markAsTaken: async (id) => {
       await axios.post(`/books/like/${id}`);
    },
    editBook: (id,name, category,author,availableCopies) => {
        console.log(id);
        console.log(category);
        console.log(author);
        return axios.put(`/books/edit/${id}`, {
            "name" : name,
            "category" : category,
            "author" : author,
            "availableCopies" : availableCopies

        })
    },
    getBook: (id) => {
        return axios.get(`/books/${id}`);
    },



}

export default EShopService;
