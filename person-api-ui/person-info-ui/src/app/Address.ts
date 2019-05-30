import { Geo } from 'src/app/Geo';
export interface Address{ 

    id: number; 
    suite: string;
    street: string; 
    city: string; 
    zipcode: string; 
    geo: Geo;
    
    
    }