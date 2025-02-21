-- Create Vendor Categories Table
CREATE TABLE IF NOT EXISTS vendor_categories (
                                                 id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    name VARCHAR(255) NOT NULL UNIQUE
    );

-- Create Vendor Statuses Table
CREATE TABLE IF NOT EXISTS vendor_statuses (
                                               id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    status_name VARCHAR(255) NOT NULL UNIQUE,
    description TEXT
    );

-- Create Vendors Table
CREATE TABLE IF NOT EXISTS vendors (
                                       id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    name VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL UNIQUE,
    phone_number VARCHAR(20),
    category_id UUID REFERENCES vendor_categories(id),
    status_id UUID REFERENCES vendor_statuses(id),
    created_at TIMESTAMP DEFAULT NOW(),
    updated_at TIMESTAMP DEFAULT NOW()
    );

-- Create Documents Table
CREATE TABLE IF NOT EXISTS documents (
                                         id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    vendor_id UUID REFERENCES vendors(id) ON DELETE CASCADE,
    doc_type VARCHAR(255) NOT NULL,
    url TEXT NOT NULL,
    uploaded_at TIMESTAMP DEFAULT NOW()
    );
