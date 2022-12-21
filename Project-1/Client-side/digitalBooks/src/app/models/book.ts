export default class Book {
    bookName: string = '';
    authorName: string = '';
    price: number = 0.00;
    genre: string = '';
    borrowed: boolean = false;
}

export class BookFilter {
    title: string = '';
    category: string = '';
    author: string = '';
    price: number = 0;
}