import { Button, Card, Divider } from '@mui/material'
import React from 'react'
import { CartItem } from './CartItem'
import { AddressCard } from './AddressCard'
import AddLocationAltIcon from '@mui/icons-material/AddLocationAlt';
const items = [1, 1,]
const Cart = () => {
    const createOrderUsingSelectedAddress = () => {

    }
    const handleOpenAddressModal = () => {

    }
    return (
        <div>
            <main className='justify-between lg:flex'>
                <section className='lg:w-[30%] space-y-6 lg:min-h-screen pt-10'>

                    {items.map((item) => <CartItem />)}
                    <Divider />
                    <div className="px-5 text-sm billDetails">
                        <p className="py-5 font-extralight">Bill Details</p>
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
                            <Divider />
                        </div>
                        <div className='flex justify-between text-gray-400'>
                            <p>Totak Pay</p>
                            <p>Rs.50.00</p>
                        </div>

                    </div>
                </section>
                <Divider orientation="vertical" flexItem />
                <section className="lg:w-[70%] flex justify-center px-5 pb-10 lg:pb-0">
                    <div>
                        <h1 className="py-10 text-2xl font-semibold text-center">Choose Delivery Address</h1>
                        <div className='flex flex-wrap justify-center gap-5'>
                            {[1, 1, 1,].map((item) => <AddressCard handleSelectAddress={createOrderUsingSelectedAddress} item={item} showButton={true} />)}

                            <Card className="flex w-64 gap-5 p-5">
                                <AddLocationAltIcon />
                                <div className="space-y-3 text-gray-500">
                                    <h1 className="text-lg font-semibold text-white">Add New Address</h1>


                                    <p>Sri Lanka,Colombo</p>

                                    <Button variant="outlined" fullWidth onClick={handleOpenAddressModal}>Add</Button>

                                </div>
                            </Card>
                        </div>


                    </div>

                </section>




            </main>
        </div>
    )
}

export default Cart