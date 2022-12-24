export default class Book {
    logo: any;
    title: string = '';
    description: string = '';
    category: string = '';
    price: number = 0.00;
    author: string = '';
    isActive: boolean = false;
    publisher: string = '';
    publishedDate: string = ''
    bookContentDetails: BookContent[] = [];
    createdTime: any;
}

export class BookContent {
    contentType: string = '';
    content: string = '';
    // createdTime: Date = new Date();
    // updatedTime: Date = new Date();
}

export class BookFilter {
    title: string = '';
    category: string = '';
    author: string = '';
    price: number = 0;
}