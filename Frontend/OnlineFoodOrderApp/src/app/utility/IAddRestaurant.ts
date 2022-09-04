export interface IAddRestaurant {
    restaurantId: number;
    restaurantName: string;
    restaurantUserName: string;
    restaurantPassword: string;
    restaurantEmail: string;
    thumbnail: File;
    attemptCount: number;
    distance: string;
    area: string;
    street: string;
    pincode: string;
}