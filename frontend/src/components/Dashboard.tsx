import React, { useEffect, useState } from 'react';
import { BarChart, Bar, XAxis, YAxis, CartesianGrid, Tooltip, Legend } from 'recharts';
import axios from 'axios';

interface AdPerformance {
    campaign: string;
    impressions: number;
    clicks: number;
}

const Dashboard = () => {
    const [data, setData] = useState<AdPerformance[]>([]);
    const [sortKey, setSortKey] = useState<string | null>(null);
    const [filterValue, setFilterValue] = useState<number | null>(null);

    useEffect(() => {
        const fetchData = async () => {
            try {
                const result = await axios.get('http://localhost:8080/api/ad-performance');
                setData(result.data);
            } catch (error) {
                console.error('Error fetching data:', error);
            }
        };

        fetchData();
    }, []);

    const filteredData = filterValue !== null
        ? data.filter(item => item.impressions > filterValue)
        : data;

    const processedData = filteredData.slice().sort((a, b) => {
        if (sortKey) {
            return a[sortKey as keyof AdPerformance] > b[sortKey as keyof AdPerformance] ? 1 : -1;
        }
        return 0;
    });

    return (
        <div>
            <h2>Ad Performance Dashboard</h2>
            <div>
                <label>Sort by:</label>
                <select onChange={(e) => setSortKey(e.target.value)} defaultValue="">
                    <option value="">None</option>
                    <option value="campaign">Campaign</option>
                    <option value="impressions">Impressions</option>
                    <option value="clicks">Clicks</option>
                </select>
            </div>
            <div>
                <label>Filter by Impressions greater than:</label>
                <input
                    type="number"
                    onChange={(e) => setFilterValue(Number(e.target.value))}
                    placeholder="Enter number"
                />
            </div>
            <BarChart width={600} height={300} data={processedData}>
                <CartesianGrid strokeDasharray="3 3" />
                <XAxis dataKey="campaign" />
                <YAxis />
                <Tooltip />
                <Legend />
                <Bar dataKey="impressions" fill="#8884d8" />
                <Bar dataKey="clicks" fill="#82ca9d" />
            </BarChart>
        </div>
    );
};

export default Dashboard;