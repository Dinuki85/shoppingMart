import { Divider } from '@mui/material'
import React from 'react'
import { CartItem } from './CartItem'

const items=[1,1,]
const Cart = () => {
  return (
    <div>
        <main className='justify-between lg:flex'>
            <section className='lg:w-[30%] space-y-6 lg:min-h-screen pt-10'>
                
              {items.map((item)=> <CartItem/>) }
              <Divider/>
              <div className="px-5 text-sm billDetails">
                <p className = "py-5 font-extralight">Bill Details</p>
                <div className='space-y-3'>
                    <div className='flex justify-between text-gray-400'>
                        <p>Item Total</p>
                        <p>Rs.999.00</p>
                        
                    </div>
                    <div className='flex justify-between text-gray-400'>
                        <p>Delive Fee</p>
                        <p>Rs.30.00</p>
                        
                    </div>
                    <div className='flex justify-between text-gray-400'>
                        <p>Shop Charges</p>
                        <p>Rs.60.00</p>
                        
                    </div>
                    <Divider/>
                </div>
                <div className='flex justify-between text-gray-400'>
                    <p>Totak Pay</p>
                    <p>Rs.50.00</p>
                </div>
                       
              </div>
            </section>
            <Divider orientation="vertical" flexItem/>
            <section className="lg:w-[70%] flex justify-center px-5 pb-10 lg:pb-0">
                
            </section>
                
                


        </main>
    </div>
  )
}

export default Cart