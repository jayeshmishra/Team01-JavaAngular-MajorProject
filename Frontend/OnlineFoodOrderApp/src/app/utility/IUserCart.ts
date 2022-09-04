import { ICart } from "./ICart";

export interface IUserCart{
    userId:number;
    cart:ICart[];
    totalAmount:number;
}