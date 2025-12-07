import { Chip, IconButton } from '@mui/material'
import React from 'react'
import RemoveCircleOutlineIcon from '@mui/icons-material/RemoveCircleOutline';
import AddCircleOutlineIcon from '@mui/icons-material/AddCircleOutline';
export const CartItem = () => {
    return (
        <div className='px-5'>
            <div className='items-center lg:flex lg:space-x-5'>
                <div>
                    <img className='w-[5rem] h-[5rem] object-cover'
                        src="https://images.pexels.com/photos/724300/pexels-photo-724300.jpeg"
                        alt="" />

                </div>
                <div className='flex items-center justify-between lg:w-[70%'>
                    <div className='w-full space-y-1 lg:space-y-3'>
                        <p>Rice</p>
                        <div className="flex items-center justify-between">
                            <IconButton>
                                <RemoveCircleOutlineIcon />
                            </IconButton>
                            <div className='flex items-center justify-center w-5 h-5 text-xs'>{5}</div>

                            <IconButton>
                                <AddCircleOutlineIcon />
                            </IconButton>
                        </div>

                    </div>
                    <p>Rs.125.00</p>
                </div>


            </div>
            <div className="pt-3 space-x-2">
                {[1, 1, 1,].map((item) => <Chip label={"rice"} />)}
            </div>

        </div>
    )
}
