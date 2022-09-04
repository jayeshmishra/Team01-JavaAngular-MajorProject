export interface IAddFood {
    foodId: number,
    foodName: string,
    price: number,
    offer: number,
    foodCategory: string,
    foodDescription: string,
    thumbnail: File,
    restaurantId: number,
    restaurantName: string,
    restaurantUserName: string,
    restaurantPassword: string,
    restaurantEmail: string,
    attemptCount: number
}