import { Customer } from './Customer';

export class Message{ 
    code: number; 
    message: string; 
    data: Object; 

    getData(){ 
        return this.data; 
    }
    
}