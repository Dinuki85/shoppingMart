import { Divider, FormControl, FormControlLabel, Grid, Radio, RadioGroup, Typography } from '@mui/material'
import React from 'react'
import LocationOnIcon from '@mui/icons-material/LocationOn';
import CalendarTodayIcon from '@mui/icons-material/CalendarToday';

const categories = [
    "pizza",
    "chicken",
    "Milk",
    "Rice"
]

const foodTypes = [
    { label: "All", value: "All" },
    { label: "Non Vegetarian", value: "Non Veg" },
    { label: "Vegetarian Only", value: "Veg" }
]
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
                    <p className='mt-1 text-gray-500'>Lorem, ipsum dolor sit amet consectetur adipisicing elit. Dolores laborum voluptas quibusdam laboriosam repudiandae aliquid sed fugit laudantium commodi reprehenderit! Libero cum asperiores velit optio minima dicta, assumenda temporibus voluptate?</p>
                    <div className='mt-3 space-y-3'>
                        <p className='flex items-center gap-3 text-gray-500'>
                            <LocationOnIcon />
                            <span>
                                Sri Lanka,Colombo                        </span>
                        </p>
                        <p className='flex items-center gap-3 text-gray-500'>

                            <CalendarTodayIcon />

                            <span>
                                Mon-Fri: 9am-5pm                        </span>

                        </p>

                    </div>

                </div>
            </section>
            <Divider />
            <section className='pt-[2rem] lg:flex relative'>
                <div className='space-y-10 lg:w-[20%] filter'>
                    <div className="space-y-5 box lg:sticky top-28 ">
                        <div>
                            <p>
                                <Typography variant="h5" sx={{ paddingBottom: "1rem" }}>
                                    Grocery Type
                                </Typography>
                            </p>
                            <FormControl className='py-10 space-y-5' component={"fieldset"}>
                                <RadioGroup>
                                    {foodTypes.map((item) => <FormControlLabel value={item.value} control={<Radio />}
                                        label={item.label} />)}

                                </RadioGroup>
                            </FormControl>

                        </div>
                    </div>
                </div>

                <div className='space-y-5 lg:w-[80%] lg:pl-10 '>

                </div>
            </section>
        </div>


    )
}

export default ShopDetail