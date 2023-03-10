USE [master]
GO
/****** Object:  Database [QLTHIETBI]    Script Date: 1/4/2023 1:15:45 PM ******/
CREATE DATABASE [QLTHIETBI]
 CONTAINMENT = NONE
 ON  PRIMARY 
( NAME = N'QLTHIETBI', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL11.SQLEXPRESS\MSSQL\DATA\QLTHIETBI.mdf' , SIZE = 6144KB , MAXSIZE = UNLIMITED, FILEGROWTH = 1024KB )
 LOG ON 
( NAME = N'QLTHIETBI_log', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL11.SQLEXPRESS\MSSQL\DATA\QLTHIETBI_log.ldf' , SIZE = 2816KB , MAXSIZE = 2048GB , FILEGROWTH = 10%)
GO
ALTER DATABASE [QLTHIETBI] SET COMPATIBILITY_LEVEL = 110
GO
IF (1 = FULLTEXTSERVICEPROPERTY('IsFullTextInstalled'))
begin
EXEC [QLTHIETBI].[dbo].[sp_fulltext_database] @action = 'enable'
end
GO
ALTER DATABASE [QLTHIETBI] SET ANSI_NULL_DEFAULT OFF 
GO
ALTER DATABASE [QLTHIETBI] SET ANSI_NULLS OFF 
GO
ALTER DATABASE [QLTHIETBI] SET ANSI_PADDING OFF 
GO
ALTER DATABASE [QLTHIETBI] SET ANSI_WARNINGS OFF 
GO
ALTER DATABASE [QLTHIETBI] SET ARITHABORT OFF 
GO
ALTER DATABASE [QLTHIETBI] SET AUTO_CLOSE OFF 
GO
ALTER DATABASE [QLTHIETBI] SET AUTO_CREATE_STATISTICS ON 
GO
ALTER DATABASE [QLTHIETBI] SET AUTO_SHRINK OFF 
GO
ALTER DATABASE [QLTHIETBI] SET AUTO_UPDATE_STATISTICS ON 
GO
ALTER DATABASE [QLTHIETBI] SET CURSOR_CLOSE_ON_COMMIT OFF 
GO
ALTER DATABASE [QLTHIETBI] SET CURSOR_DEFAULT  GLOBAL 
GO
ALTER DATABASE [QLTHIETBI] SET CONCAT_NULL_YIELDS_NULL OFF 
GO
ALTER DATABASE [QLTHIETBI] SET NUMERIC_ROUNDABORT OFF 
GO
ALTER DATABASE [QLTHIETBI] SET QUOTED_IDENTIFIER OFF 
GO
ALTER DATABASE [QLTHIETBI] SET RECURSIVE_TRIGGERS OFF 
GO
ALTER DATABASE [QLTHIETBI] SET  DISABLE_BROKER 
GO
ALTER DATABASE [QLTHIETBI] SET AUTO_UPDATE_STATISTICS_ASYNC OFF 
GO
ALTER DATABASE [QLTHIETBI] SET DATE_CORRELATION_OPTIMIZATION OFF 
GO
ALTER DATABASE [QLTHIETBI] SET TRUSTWORTHY OFF 
GO
ALTER DATABASE [QLTHIETBI] SET ALLOW_SNAPSHOT_ISOLATION OFF 
GO
ALTER DATABASE [QLTHIETBI] SET PARAMETERIZATION SIMPLE 
GO
ALTER DATABASE [QLTHIETBI] SET READ_COMMITTED_SNAPSHOT OFF 
GO
ALTER DATABASE [QLTHIETBI] SET HONOR_BROKER_PRIORITY OFF 
GO
ALTER DATABASE [QLTHIETBI] SET RECOVERY SIMPLE 
GO
ALTER DATABASE [QLTHIETBI] SET  MULTI_USER 
GO
ALTER DATABASE [QLTHIETBI] SET PAGE_VERIFY CHECKSUM  
GO
ALTER DATABASE [QLTHIETBI] SET DB_CHAINING OFF 
GO
ALTER DATABASE [QLTHIETBI] SET FILESTREAM( NON_TRANSACTED_ACCESS = OFF ) 
GO
ALTER DATABASE [QLTHIETBI] SET TARGET_RECOVERY_TIME = 0 SECONDS 
GO
USE [QLTHIETBI]
GO
/****** Object:  Table [dbo].[LOAITB]    Script Date: 1/4/2023 1:15:45 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[LOAITB](
	[maloai] [nchar](5) NOT NULL,
	[tenloai] [nvarchar](100) NULL,
 CONSTRAINT [PK_LOAITB] PRIMARY KEY CLUSTERED 
(
	[maloai] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[LOGIN]    Script Date: 1/4/2023 1:15:45 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[LOGIN](
	[username] [nchar](10) NOT NULL,
	[password] [nvarchar](100) NULL,
 CONSTRAINT [PK_LOGIN] PRIMARY KEY CLUSTERED 
(
	[username] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[NHANVIEN]    Script Date: 1/4/2023 1:15:45 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[NHANVIEN](
	[manv] [nchar](5) NOT NULL,
	[tennv] [nvarchar](100) NULL,
	[sdtnv] [nchar](15) NULL,
	[diachi] [nvarchar](100) NULL,
	[gioitinh] [bit] NULL,
 CONSTRAINT [PK_NHANVIEN] PRIMARY KEY CLUSTERED 
(
	[manv] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[PHANCONG]    Script Date: 1/4/2023 1:15:45 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[PHANCONG](
	[manv] [nchar](5) NOT NULL,
	[map] [nchar](5) NOT NULL,
	[matb] [nchar](5) NOT NULL,
	[soluong] [float] NULL,
	[ngaytrangbi] [date] NULL,
	[trangthai] [nvarchar](150) NULL,
 CONSTRAINT [PK_PHANCONG] PRIMARY KEY CLUSTERED 
(
	[manv] ASC,
	[map] ASC,
	[matb] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[PHONGBAN]    Script Date: 1/4/2023 1:15:45 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[PHONGBAN](
	[map] [nchar](5) NOT NULL,
	[tenp] [nvarchar](100) NULL,
 CONSTRAINT [PK_PHONGBAN] PRIMARY KEY CLUSTERED 
(
	[map] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[THIETBI]    Script Date: 1/4/2023 1:15:45 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[THIETBI](
	[matb] [nchar](5) NOT NULL,
	[tentb] [nvarchar](100) NULL,
	[ngaysx] [date] NULL,
	[thoigianbaohanh] [nvarchar](100) NULL,
	[giamua] [float] NULL,
	[dvt] [nchar](50) NULL,
	[maloai] [nchar](5) NULL,
 CONSTRAINT [PK_THIETBI] PRIMARY KEY CLUSTERED 
(
	[matb] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
INSERT [dbo].[LOAITB] ([maloai], [tenloai]) VALUES (N'DD   ', N'Đồ Điện')
INSERT [dbo].[LOAITB] ([maloai], [tenloai]) VALUES (N'DDT  ', N'Đồ Điên Tử')
INSERT [dbo].[LOAITB] ([maloai], [tenloai]) VALUES (N'DG   ', N'Đồ Gỗ')
INSERT [dbo].[LOGIN] ([username], [password]) VALUES (N'admin     ', N'admin     ')
INSERT [dbo].[LOGIN] ([username], [password]) VALUES (N'chien     ', N'123123    ')
INSERT [dbo].[NHANVIEN] ([manv], [tennv], [sdtnv], [diachi], [gioitinh]) VALUES (N'NV001', N'Nguyễn Văn A', N'0123456789     ', N'123-bình long', 1)
INSERT [dbo].[NHANVIEN] ([manv], [tennv], [sdtnv], [diachi], [gioitinh]) VALUES (N'NV002', N'Vân Thị B', N'0236578455     ', N'Phú Nhuận, TP.HCM', 0)
INSERT [dbo].[NHANVIEN] ([manv], [tennv], [sdtnv], [diachi], [gioitinh]) VALUES (N'NV003', N'Hồ THị C', N'023613556      ', N'Ba Vân, Tân Bình', 0)
INSERT [dbo].[PHANCONG] ([manv], [map], [matb], [soluong], [ngaytrangbi], [trangthai]) VALUES (N'NV001', N'CV   ', N'B01  ', 2, CAST(0xC1440B00 AS Date), N'Đã sử dụng')
INSERT [dbo].[PHANCONG] ([manv], [map], [matb], [soluong], [ngaytrangbi], [trangthai]) VALUES (N'NV001', N'CV   ', N'DK001', 8, CAST(0xC0440B00 AS Date), N'Đã sử dụng')
INSERT [dbo].[PHANCONG] ([manv], [map], [matb], [soluong], [ngaytrangbi], [trangthai]) VALUES (N'NV001', N'CV   ', N'G01  ', 8, CAST(0xC0440B00 AS Date), N'Đã sử dụng')
INSERT [dbo].[PHANCONG] ([manv], [map], [matb], [soluong], [ngaytrangbi], [trangthai]) VALUES (N'NV001', N'CV   ', N'ML001', 2, CAST(0xC0440B00 AS Date), N'Đã sử dụng')
INSERT [dbo].[PHANCONG] ([manv], [map], [matb], [soluong], [ngaytrangbi], [trangthai]) VALUES (N'NV001', N'CV   ', N'TV001', 8, CAST(0xC0440B00 AS Date), N'Đã sử dụng')
INSERT [dbo].[PHANCONG] ([manv], [map], [matb], [soluong], [ngaytrangbi], [trangthai]) VALUES (N'NV002', N'HC   ', N'B01  ', 4, CAST(0xC0440B00 AS Date), N'Đã sử dụng')
INSERT [dbo].[PHANCONG] ([manv], [map], [matb], [soluong], [ngaytrangbi], [trangthai]) VALUES (N'NV002', N'HC   ', N'DH001', 4, CAST(0xC1440B00 AS Date), N'Đã sử dụng')
INSERT [dbo].[PHANCONG] ([manv], [map], [matb], [soluong], [ngaytrangbi], [trangthai]) VALUES (N'NV002', N'HC   ', N'G01  ', 8, CAST(0xC0440B00 AS Date), N'Đã sử dụng')
INSERT [dbo].[PHANCONG] ([manv], [map], [matb], [soluong], [ngaytrangbi], [trangthai]) VALUES (N'NV002', N'HC   ', N'MT001', 4, CAST(0xC0440B00 AS Date), N'Đã sử dụng')
INSERT [dbo].[PHANCONG] ([manv], [map], [matb], [soluong], [ngaytrangbi], [trangthai]) VALUES (N'NV002', N'HC   ', N'TV001', 2, CAST(0xC0440B00 AS Date), N'Đã sử dụng')
INSERT [dbo].[PHANCONG] ([manv], [map], [matb], [soluong], [ngaytrangbi], [trangthai]) VALUES (N'NV003', N'TV   ', N'B01  ', 4, CAST(0xC0440B00 AS Date), N'Đã sử dụng')
INSERT [dbo].[PHANCONG] ([manv], [map], [matb], [soluong], [ngaytrangbi], [trangthai]) VALUES (N'NV003', N'TV   ', N'BD001', 5, CAST(0xC9440B00 AS Date), N'Đã sử dụng')
INSERT [dbo].[PHANCONG] ([manv], [map], [matb], [soluong], [ngaytrangbi], [trangthai]) VALUES (N'NV003', N'TV   ', N'DH001', 4, CAST(0xC0440B00 AS Date), N'Đã sử dụng')
INSERT [dbo].[PHANCONG] ([manv], [map], [matb], [soluong], [ngaytrangbi], [trangthai]) VALUES (N'NV003', N'TV   ', N'G01  ', 4, CAST(0xC0440B00 AS Date), N'Đã sử dụng')
INSERT [dbo].[PHANCONG] ([manv], [map], [matb], [soluong], [ngaytrangbi], [trangthai]) VALUES (N'NV003', N'TV   ', N'ML001', 4, CAST(0xC0440B00 AS Date), N'Đã sử dụng')
INSERT [dbo].[PHONGBAN] ([map], [tenp]) VALUES (N'CV   ', N'Công Vụ')
INSERT [dbo].[PHONGBAN] ([map], [tenp]) VALUES (N'HC   ', N'Hành Chính')
INSERT [dbo].[PHONGBAN] ([map], [tenp]) VALUES (N'TV   ', N'Tư Vấn')
INSERT [dbo].[THIETBI] ([matb], [tentb], [ngaysx], [thoigianbaohanh], [giamua], [dvt], [maloai]) VALUES (N'B01  ', N'Bàn Học', CAST(0xE6410B00 AS Date), N'2Y', 80000, N'VNĐ                                               ', N'DG   ')
INSERT [dbo].[THIETBI] ([matb], [tentb], [ngaysx], [thoigianbaohanh], [giamua], [dvt], [maloai]) VALUES (N'BD001', N'Bóng đèn', CAST(0xE8410B00 AS Date), N'2Y', 180000, N'VNĐ                                               ', N'DD   ')
INSERT [dbo].[THIETBI] ([matb], [tentb], [ngaysx], [thoigianbaohanh], [giamua], [dvt], [maloai]) VALUES (N'BT001', N'Bàn Xoay', CAST(0xB9440B00 AS Date), N'2Y', 100000, N'VNĐ                                               ', N'DG   ')
INSERT [dbo].[THIETBI] ([matb], [tentb], [ngaysx], [thoigianbaohanh], [giamua], [dvt], [maloai]) VALUES (N'DH001', N'Điều hòa', CAST(0x7D400B00 AS Date), N'3Y', 180000, N'VNĐ                                               ', N'DD   ')
INSERT [dbo].[THIETBI] ([matb], [tentb], [ngaysx], [thoigianbaohanh], [giamua], [dvt], [maloai]) VALUES (N'DK001', N'Điều Khiển', CAST(0xC0440B00 AS Date), N'1Y', 15000, N'VNĐ                                               ', N'DDT  ')
INSERT [dbo].[THIETBI] ([matb], [tentb], [ngaysx], [thoigianbaohanh], [giamua], [dvt], [maloai]) VALUES (N'G01  ', N'Ghế Xoay', CAST(0xE9410B00 AS Date), N'2Y', 50000, N'VNĐ                                               ', N'DG   ')
INSERT [dbo].[THIETBI] ([matb], [tentb], [ngaysx], [thoigianbaohanh], [giamua], [dvt], [maloai]) VALUES (N'ML001', N'Máy Lạnh', CAST(0xB9440B00 AS Date), N'2Y', 120000, N'VNĐ                                               ', N'DD   ')
INSERT [dbo].[THIETBI] ([matb], [tentb], [ngaysx], [thoigianbaohanh], [giamua], [dvt], [maloai]) VALUES (N'MT001', N'Màn Hình Máy Tính', CAST(0xBF440B00 AS Date), N'3Y', 100000, N'USD                                               ', N'DDT  ')
INSERT [dbo].[THIETBI] ([matb], [tentb], [ngaysx], [thoigianbaohanh], [giamua], [dvt], [maloai]) VALUES (N'TV001', N'TiVi', CAST(0xE9410B00 AS Date), N'2Y', 123000, N'VNĐ                                               ', N'DDT  ')
ALTER TABLE [dbo].[PHANCONG]  WITH CHECK ADD  CONSTRAINT [FK_PHANCONG_NHANVIEN] FOREIGN KEY([manv])
REFERENCES [dbo].[NHANVIEN] ([manv])
GO
ALTER TABLE [dbo].[PHANCONG] CHECK CONSTRAINT [FK_PHANCONG_NHANVIEN]
GO
ALTER TABLE [dbo].[PHANCONG]  WITH CHECK ADD  CONSTRAINT [FK_PHANCONG_PHONGBAN] FOREIGN KEY([map])
REFERENCES [dbo].[PHONGBAN] ([map])
GO
ALTER TABLE [dbo].[PHANCONG] CHECK CONSTRAINT [FK_PHANCONG_PHONGBAN]
GO
ALTER TABLE [dbo].[PHANCONG]  WITH CHECK ADD  CONSTRAINT [FK_PHANCONG_THIETBI] FOREIGN KEY([matb])
REFERENCES [dbo].[THIETBI] ([matb])
GO
ALTER TABLE [dbo].[PHANCONG] CHECK CONSTRAINT [FK_PHANCONG_THIETBI]
GO
ALTER TABLE [dbo].[THIETBI]  WITH CHECK ADD  CONSTRAINT [FK_THIETBI_LOAITB] FOREIGN KEY([maloai])
REFERENCES [dbo].[LOAITB] ([maloai])
GO
ALTER TABLE [dbo].[THIETBI] CHECK CONSTRAINT [FK_THIETBI_LOAITB]
GO
USE [master]
GO
ALTER DATABASE [QLTHIETBI] SET  READ_WRITE 
GO
