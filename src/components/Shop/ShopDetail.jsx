import { Grid } from '@mui/material'
import React from 'react'
import LocationOnIcon from '@mui/icons-material/LocationOn';
import CalendarTodayIcon from '@mui/icons-material/CalendarToday';
const ShopDetail = () => {
    return (
        <div className='px-5 lg:px-20'>
            <section>
                <h3 className='mb-4 font-serif font-semibold'>Home/Sri Lanka/Grocery Items/3</h3>
                <div>
                    <Grid container spacing={2}>
                        <Grid item xs={12}  >
                            <img className="object-cover w-full h-100"
                                src="https://images.pexels.com/photos/264636/pexels-photo-264636.jpeg"
                                alt=""

                            />
                        </Grid>




                    </Grid>
                </div>
                <div className="pt-3 pb-50">
                    <h1 className='text-4xl font-semibold'>Sri Lanka Best Grocesry Items</h1>
                    <p className='flex items-center gap-3 text-gray-500'>
                        <LocationOnIcon />
                        <span>
                            Lorem ipsum dolor sit amet consectetur adipisicing elit. Quibusdam ad ratione illum omnis eligendi in? Repudiandae molestias provident quisquam quae repellendus quasi error temporibus, nihil libero, culpa est distinctio neque!
                        </span>
                    </p>
                    <p className='flex items-center gap-3 text-gray-500'>

                        <CalendarTodayIcon />

                        <span>
                            Mon-Fri: 9am-5pm                        </span>

                    </p>
                </div>
            </section>
        </div>


    )
}

export default ShopDetail