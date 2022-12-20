import { Action } from "@ngrx/store";

export class ActionParent implements Action {
    type: any;
    payload: any;
}

export class TodoAdd implements ActionParent {
    type: any;
    constructor(public payload: any) {

    };
}