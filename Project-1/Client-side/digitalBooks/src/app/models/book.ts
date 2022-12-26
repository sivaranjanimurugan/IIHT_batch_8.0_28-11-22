export default class Book {
    logo: string = '';
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
}

export class BookFilter {
    title: string = '';
    category: string = '';
    author: string = '';
    price: number = 0;
}

export class SubscribeDetails {
    subName: string = '';
    subRole: string = '';
    isSubscribed: boolean = false;
}

export class Notification {
    username: string = '';
    msg: string = '';
    createdTime: any;
}