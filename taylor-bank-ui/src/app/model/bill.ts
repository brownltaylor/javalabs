

export class Bill{ 

    id: number; 
    status: Status; 
    payee: string; 
    nickname: string; 
    creation_date: string; 
    payment_date: string; 
    recurring_date: number; 
    upcoming_payment_date: string; 
    payment_amount: number; 
    account_id: number
}

export enum Status{ 
    Pending = 'PENDING', 
    Cancelled = 'CANCELLED', 
    Completed = 'COMPLETED',
    Recurring = 'RECCURING'
}