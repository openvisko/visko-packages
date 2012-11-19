
%Generate simulated image for future simulation
% orientation of the nanorods are assumed randomly.

function image=generate_images(GH,GW,numrec,numtri,numrice,rodsw,...
    rodsh,triheight,trisize,ricelong,riceshort,imagen,drawimage)

% GH=5000;
% GW=5000;
% numrec=10;
% numtri=10;
% numrice=30;
% rodsw=17.5;
% rodsh=75;
% triheight=26;
% triheight=69;
% trisize=80;
% ricelong=20.5;
% riceshort=10.2;


% % rodsw=15;
% % rodsh=25;
% % triheight=10;
% % trisize=15;
% % ricelong=20;
% % riceshort=15;
%
% % rodsw=50;
% % rodsh=50;
% % triheight=50;
% % trisize=50;
% % ricelong=50;
% % riceshort=50;
%
particlenum=numrec+numtri+numrice;
pi=3.1415926535;
mutualdistance=3;

sizeall=[rodsw,rodsh,trisize,triheight,ricelong];
margin=max(sizeall);
lengthx=GW-4*margin;
lengthy=GH-4*margin;


image=ones(GH,GW);
% center point of the rods.
centerpoints=zeros(particlenum,2);

%   Now plot the rectangular particles
for rodn=1:numrec
    Bgoodpoint=0;
    while (Bgoodpoint==0)
        pos=rand(2,1);
        position=[2*margin+pos(1)*lengthx, 2*margin+pos(2)*lengthy];
        centerpoints(rodn,:)=position;
        Bgoodpoint=1;
        if rodn>1
            for j=1:rodn-1
                if Bgoodpoint==1
                    distance=0;
                    for k=1:2
                        distance=distance+(centerpoints(j,k)-centerpoints(rodn,k))^2;
                    end;
                    if distance<((mutualdistance*margin)^2)
                        Bgoodpoint=0;
                    end;
                end;
            end;
        end;
    end;
    % define the rods.
    angle=rand(1)*pi;
    head(1)=position(1)+rodsh*cos(angle)/2;
    head(2)=position(2)+rodsh*sin(angle)/2;
    tail(1)=position(1)-rodsh*cos(angle)/2;
    tail(2)=position(2)-rodsh*sin(angle)/2;
    % define the points in the rods one layer by one layer
    for m=0:4*rodsw
        headn(1)=head(1)+m*cos(pi/2+angle)/4.0;
        headn(2)=head(2)+m*sin(pi/2+angle)/4.0;
        for j=0:4*rodsh
            xposition=round(headn(1)+j*cos(angle)/4.0);
            yposition=round(headn(2)+j*sin(angle)/4.0);
            image(xposition,yposition)=0;
            
        end;
    end;
end;

%   Now plot the nanoprism particles
for rodn=1:numtri
    Bgoodpoint=0;
    rodntri=rodn+numrec;
    while (Bgoodpoint==0)
        pos=rand(2,1);
        position=[2*margin+pos(1)*lengthx, 2*margin+pos(2)*lengthy];
        centerpoints(rodntri,:)=position;
        Bgoodpoint=1;
        if rodntri>1
            for j=1:rodntri-1
                if Bgoodpoint==1
                    distance=0;
                    for k=1:2
                        distance=distance+(centerpoints(j,k)-centerpoints(rodntri,k))^2;
                    end;
                    if distance<((mutualdistance*margin)^2)
                        Bgoodpoint=0;
                    end;
                end;
            end;
        end;
    end;
    % define the rods.
    angle=rand(1)*pi;
    head(1)=position(1)+triheight*cos(angle)/2;
    head(2)=position(2)+triheight*sin(angle)/2;
    tail(1)=position(1)-triheight*cos(angle)/2;
    tail(2)=position(2)-triheight*sin(angle)/2;
    % define the points in the rods one layer by one layer
    for m=0:4*triheight
        headn(1)=head(1)+m*cos(angle)/4.0;
        headn(2)=head(2)+m*sin(angle)/4.0;
        trisizen=round(m*trisize/4/triheight);
        for j=-2*trisizen:2*trisizen
            xposition=round(headn(1)+j*cos(pi/2+angle)/4.0);
            yposition=round(headn(2)+j*sin(pi/2+angle)/4.0);
            image(xposition,yposition)=0;
            
        end;
    end;
end;

%   Now plot the nanorice particles
for rodn=1:numrice
    Bgoodpoint=0;
    rodnrice=rodn+numrec+numtri;
    while (Bgoodpoint==0)
        pos=rand(2,1);
        position=[2*margin+pos(1)*lengthx, 2*margin+pos(2)*lengthy];
        centerpoints(rodnrice,:)=position;
        Bgoodpoint=1;
        if rodnrice>1
            for j=1:rodnrice-1
                if Bgoodpoint==1
                    distance=0;
                    for k=1:2
                        distance=distance+(centerpoints(j,k)-centerpoints(rodnrice,k))^2;
                    end;
                    if distance<((mutualdistance*margin)^2)
                        Bgoodpoint=0;
                    end;
                end;
            end;
        end;
    end;
    angle=rand(1)*pi;
    % define the points in the rices one layer by one layer
    for m=0:4*ricelong
        headn(1)=position(1)+m*cos(angle)/4.0;
        headn(2)=position(2)+m*sin(angle)/4.0;
        ricewn=round(riceshort*sqrt(1-(m/2/ricelong-1)^2));
        for j=-2*ricewn:2*ricewn
            xposition=round(headn(1)+j*cos(pi/2+angle)/4.0);
            yposition=round(headn(2)+j*sin(pi/2+angle)/4.0);
            image(xposition,yposition)=0;
            
        end;
    end;
end;

if drawimage==1
    out1=int2str(imagen);
    fimage=['image' out1 '.tif'];
    imwrite(image, fimage, 'tif');
end;

% fimagesc=['imagesc' out1, '.tif'];
% imagesc(image);
% print('-dtiff', fimagesc);


