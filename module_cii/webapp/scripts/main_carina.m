% This is the main program to run data analysis for FXS

% imageno=100;
imageno=1;
GH=5000;
GW=5000;
numrec=10;
numtri=10;
numrice=30;
rodsw=17.5;
rodsh=75;
triheight=69;
trisize=80;
ricelong=20.5;
riceshort=10.2;

rmin = 100; % minimum radius
rmax = 2000; % maximum radius value
dr = 10;    % step size in radius (use sampling arguments to define this)
dphi = pi/180; % step size in angle
RR1 = floor(rmin/dr);
RR2 = floor(rmax/dr);

phis = 0:dphi:(2*pi-dphi); % phi values in polar binned image
rs = (floor(rmin/dr):floor(rmax/dr))*dr; % r values

nr = numel(rs);     % number of rs in the polar binned image
nphi = numel(phis); % number of phi values
totalfluc_ccf=zeros(nphi, nr);

% switch to draw image out or not
% drawimage=0 No image plot
% drawimage=1 Yes image plot
drawimage=1;

for i=1:imageno
    image=generate_images(GH,GW,numrec,numtri,numrice,rodsw,...
        rodsh,triheight,trisize,ricelong,riceshort,i,drawimage);
%     diffimg=diffraction(image,i,drawimage);
%     fluc_ccf=diff2RAC(diffimg,i,drawimage);
%     totalfluc_ccf=totalfluc_ccf+fluc_ccf;
%     plotRAC(totalfluc_ccf,'totalRAC.tif',RR1,RR2);
end;

